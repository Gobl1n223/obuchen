package com.example.obuchen.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "note")
@NoArgsConstructor
public class Note {

        public Note(String title, String note, Long userId) {
                this.title = title;
                this.note = note;
                this.userId = userId;
        }

        @Id
        @GeneratedValue(generator = "increment")
        @GenericGenerator(name = "increment", strategy = "increment")
        private Long id;

        private String title;
        private String note;
        private Long userId;
}
