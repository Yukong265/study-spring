package com.example.studyspring.domain.chat.present;


import com.example.studyspring.domain.chat.present.dto.MsgRoom;
import com.example.studyspring.domain.chat.service.MsgService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
    private final MsgService msgService;

    @PostMapping
    public MsgRoom createRoom(@RequestParam String name){
        return msgService.createRoom(name);
    }

    @GetMapping
    public List<MsgRoom> findAllRoom(){
        return msgService.findAllRoom();
    }
}
