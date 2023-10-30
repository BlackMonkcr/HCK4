package com.example.demo.Application;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Domain.*;
import java.util.List;


@RestController
@RequestMapping("/join")
public class JoinController {
    private final JoinService joinService;

    @Autowired
    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @PostMapping("/{group_id}/{person_id}")
    public void createJoin(@PathVariable Long group_id, @PathVariable Long person_id) {
        joinService.joinGroup(person_id, group_id);
    }

    @DeleteMapping("/{group_id}/{person_id}")
    public void deleteJoin(@PathVariable Long group_id, @PathVariable Long person_id) {
        joinService.leaveGroup(person_id, group_id);
    }
}
