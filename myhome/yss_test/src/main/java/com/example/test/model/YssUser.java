package com.example.test.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table @Data
@NoArgsConstructor
public class YssUser {
    
    @Id
    private Long userIndex;

    @Column
    private String userId;

    @Column
    private String userPassword;

    @Column
    private String userName;
    
    @Column
    private String userStatus;
    
    @Column
    private Timestamp userRegistDate;


}
