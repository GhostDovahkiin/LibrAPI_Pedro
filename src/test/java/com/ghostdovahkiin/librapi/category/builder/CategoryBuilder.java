package com.ghostdovahkiin.librapi.category.builder;

import com.ghostdovahkiin.librapi.category.Category;

public class CategoryBuilder {
    public static Category.Builder createCategory() {
        return Category.builder()
                .id(123L)
                .name("Mathematics");
    }
}
