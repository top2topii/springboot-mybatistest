package co.primeblock.mybatistest.dao;

import java.util.List;

import co.primeblock.mybatistest.dto.MessageDto;

public interface MessageDao {
    MessageDto selectMessage(int id) throws Exception;
    List<MessageDto> selectMessageAll() throws Exception;
    void createMessage(MessageDto m) throws Exception;
}
