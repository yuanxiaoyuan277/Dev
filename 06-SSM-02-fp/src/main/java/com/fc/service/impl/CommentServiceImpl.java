package com.fc.service.impl;

import com.fc.dao.MessageBoardMapper;
import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.CommentService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Override
    public ResultVO add(MessageBoardWithBLOBs messageBoards) {
        if (messageBoards.getCreateTime() == null){
            messageBoards.setCreateTime(new Date());
        }

        int i = messageBoardMapper.insertSelective(messageBoards);

        ResultVO resultVO;
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, null);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO del(Long id) {
        int i = messageBoardMapper.deleteByPrimaryKey(id);

        ResultVO resultVO;
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, null);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO update(MessageBoardWithBLOBs messageBoards) {
        int i = messageBoardMapper.updateByPrimaryKeySelective(messageBoards);
        MessageBoard result = messageBoardMapper.selectByPrimaryKey(messageBoards.getId());

        ResultVO resultVO;
        if (i > 0){
            resultVO = new ResultVO(200, "OK", true, result);
        }else {
            resultVO = new ResultVO(-1000, "fail", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize,Long userId) {
        List<MessageBoardWithBLOBs> messageBoards;
        ResultVO resultVO;
        try {
            if (userId == null){
                PageHelper.startPage(pageNum,pageSize);

                messageBoards = messageBoardMapper.selectByExampleWithBLOBs(null);
            }else {
                MessageBoardWithBLOBs messageBoardWithBLOBs = messageBoardMapper.selectByUserId(userId);
                messageBoards = new ArrayList<>();
                messageBoards.add(messageBoardWithBLOBs);

            }
            PageInfo<MessageBoardWithBLOBs> pageInfo = new PageInfo<>(messageBoards);

            DataVO<MessageBoardWithBLOBs> dataVO = new DataVO<>(pageInfo.getTotal(),messageBoards,pageNum,pageSize);

            resultVO = new ResultVO(200,"OK",true,dataVO);

        }catch (Exception e){
            resultVO = new ResultVO(-10000,"fail",false,null);
        }
        return resultVO;
    }
}
