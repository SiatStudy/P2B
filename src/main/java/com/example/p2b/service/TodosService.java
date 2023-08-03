package com.example.p2b.service;

import com.example.p2b.domain.User;
import com.example.p2b.domain.Todos;
import com.example.p2b.repository.TodosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodosService {
    private final TodosRepository todosRepository;

    @Transactional
    public void addTodos(String tdTitle, String tdContent, LocalDateTime tdEnd, LocalDateTime tdStart, int tdStartYear, User user){
        Todos todos = new Todos(tdTitle, tdContent, tdEnd, tdStartYear, tdStart);
        todos.setUser(user);
        todosRepository.save(todos);
    }

    public List<Todos> findTodoList(int tdyddate, User user){
//        /*
//            1. 요청받은 년도로 투두스 리스트 색인
//            2. 색인 해온 데이터를 OutDTO형식으로 리턴
//         */
        List<Todos> todosList = todosRepository.findByTdstartyeardateAndUser(tdyddate, user);
        return todosList;
    }

    @Transactional
    public void deleteTodos(Long tdid){
        todosRepository.deleteById(tdid);
    }
}
