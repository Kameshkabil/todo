package com.example.crud.todo.entity;





import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;


public class TaskInfo {

//    @GeneratedValue(strategy = GenerationType.SEQUENCE)



  //  private static long idCounter = 0;

    private Long id;
    private String name;
    private String description;
    private String status;

    public Long getId() {
//      Long newId =idCounter++;
//       this.id = newId;
       return id;
    }

    public void setId(long id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
