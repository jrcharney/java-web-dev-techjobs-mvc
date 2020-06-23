package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.launchcode.javawebdevtechjobsmvc.models.Job;
import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
    // TODO #3.5 - If the searchbox empty or the query is "all" use findAll() like in ListController.
    @RequestMapping(value="results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        ArrayList<Job> jobs;
        if(searchTerm != null || searchTerm.toLowerCase().equals("all")) {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("title", "Search for " + searchTerm + " in " + columnChoices.get(searchType));
        } else {
            jobs = JobData.findAll();
            model.addAttribute("title", "All Jobs");
        }

        model.addAttribute("type", searchType);
        model.addAttribute("columns", columnChoices);
        model.addAttribute("jobs", jobs);

        return "search";
    }
}
