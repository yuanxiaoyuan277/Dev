package com.fc.service.impl;

import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNoteType;
import com.fc.service.TypeService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;

    @Override
    public ResultVO getList(Integer id) {

        return null;
    }

    @Override
    public ResultVO delete(Integer id) {
        TbNoteType tbNoteType = tbNoteTypeMapper.selectNotTypeById(id);
        ResultVO resultVO = null;
        if (tbNoteType == null){
            resultVO = new ResultVO(0, "删除失败", false, null);
        }else {
            int i = tbNoteTypeMapper.deleteByPrimaryKey(id);

            resultVO = new ResultVO(1, "删除成功", false, null);
        }
        return resultVO;
    }

    @Override
    public ResultVO addOrUpdate(Integer typeId, String typeName, Integer id) {
        return null;
    }
}
