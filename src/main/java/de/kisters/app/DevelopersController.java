package de.kisters.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The controller will map request URIs to view templates
 * and perform all necessary processing in between.
 * Created by ak on 25.01.2017.
 */
@Controller public class DevelopersController {
    @Autowired
    DeveloperRepository developerRepo;

    @Autowired
    SkillRepository skillRepo;

    /**
     * @param id    to search
     * @param model data to be passed to view (in essence simple maps of key->value)
     * @return the name of the GUI template
     */
    @RequestMapping("/developer/{id}") public String developer(@PathVariable Long id, Model model) {
        model.addAttribute("developer", developerRepo.findOne(id));
        model.addAttribute("skills", skillRepo.findAll());
        return "developer";
    }

    @RequestMapping(value = "/developers", method = RequestMethod.GET) public String developersList(Model model) {
        model.addAttribute("developers", developerRepo.findAll()); //data to be passed to view template
        return "developers"; //just a name of template to show with
    }

    /**
     * Create and save new developer ant then redirect to the developer view (for this new one)
     */
    @RequestMapping(value = "/developers", method = RequestMethod.POST) public String developersAdd(@RequestParam String firstName,
        @RequestParam String lastName, @RequestParam String email, Model model) {
        Developer newDeveloper = new Developer();
        newDeveloper.setFirstName(firstName);
        newDeveloper.setLastName(lastName);
        newDeveloper.setEmail(email);
        developerRepo.save(newDeveloper);

        model.addAttribute("developer", newDeveloper);
        model.addAttribute("skills", skillRepo.findAll());

        return "redirect:/developer/" + newDeveloper.getId();

    }

    /**
     * Add the special skill to selected developer and redirect to the detailed view
     * If no developer has been found for this id - redirect to the list view
     *
     */
    @RequestMapping(value = "/developer/{id}/skills", method = RequestMethod.POST) public String developersAddSkill(@PathVariable Long id,
        @RequestParam Long skillId, Model model) {

        Skill skill = skillRepo.findOne(skillId);
        Developer developer = developerRepo.findOne(id);

        if (developer != null) {
            if (!developer.hasSkill(skill)) {
                developer.getSkills().add(skill);
                developerRepo.save(developer);
            }
            model.addAttribute("developer", developer);
            model.addAttribute(skillRepo.findAll());
            return "redirect:/developer/" + developer.getId();
        }
        model.addAttribute("developers", developerRepo.findAll());
        return "redirect:/developers";
    }
}
