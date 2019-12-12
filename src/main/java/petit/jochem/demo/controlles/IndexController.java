package petit.jochem.demo.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import petit.jochem.demo.model.Blog;
import petit.jochem.demo.model.BlogDAO;

import javax.validation.Valid;

@Controller
public class IndexController {
    @Autowired
    BlogDAO dao;

    @ModelAttribute(value = "allBlog")
    public Iterable<Blog> getAllBlogs() {
        return dao.findAll();
    }

    @ModelAttribute(value = "newBlog")
    public Blog BlogToSave() {
        return new Blog();
    }

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map) {
        return "index";
    }

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.POST)
    public String saveSnack(@ModelAttribute("newBlog") @Valid Blog newBlog, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "index";
        dao.save(newBlog);
        return "redirect:/index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBlog(@PathVariable(value = "id") int id) {
        dao.deleteById(id);
        return "redirect:/index";
    }
}