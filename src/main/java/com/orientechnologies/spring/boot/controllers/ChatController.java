package com.orientechnologies.spring.boot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.orientechnologies.spring.boot.dto.Message;

/**
 * Created by Enrico Risa on 17/10/15.
 */

@RestController
@RequestMapping("rooms")
public class ChatController {

  @RequestMapping(value = "{room}", method = RequestMethod.POST)
  public ResponseEntity postMessage(@PathVariable("name") String name, @RequestBody Message message) {

    return new ResponseEntity(HttpStatus.OK);
  }
}
