package com.example.miniapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Document(collection = "ratings")
public class Rating {
}
