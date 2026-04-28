package com.example.demo.service.student;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DefaultStudentService implements StudentService {



    public Student getStudent(Long id){
        log.info("Attempting to retrieve student with id: {}", id);
        return null;

    }
}
