package com.fc.controller;

import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.CommentService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")
public class comment {
    @Autowired
    private CommentService commentService;

    @RequestMapping("add")
    public ResultVO add(@RequestBody MessageBoardWithBLOBs messageBoards){
        return commentService.add(messageBoards);
    }

    @RequestMapping("del")
    public ResultVO del(Long id){
        return commentService.del(id);
    }

    @RequestMapping("update")
    public ResultVO update(@RequestBody MessageBoardWithBLOBs messageBoards){
        return commentService.update(messageBoards);
    }
    @RequestMapping("getList")
    public ResultVO getList(@RequestParam(value = "pageNum",required = false, defaultValue = "1")Integer pageNum
            , @RequestParam(value = "pageSize" ,required = false,defaultValue = "3")Integer pageSize
            , MessageBoard messageBoard){
        return commentService.getList(pageNum,pageSize,messageBoard.getUserId());
    }

}
