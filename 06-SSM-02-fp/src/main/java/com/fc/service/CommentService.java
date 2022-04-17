package com.fc.service;

import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.vo.ResultVO;

public interface CommentService {
    ResultVO add(MessageBoardWithBLOBs messageBoards);

    ResultVO del(Long id);

    ResultVO update(MessageBoardWithBLOBs messageBoards);

    ResultVO getList(Integer pageNum, Integer pageSize, String username);
}
