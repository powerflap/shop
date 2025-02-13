package org.skypro.skyshop.article;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;



@SuppressWarnings("all")
public final class Article implements org.skypro.skyshop.searcheble.Searchable {
    @NotNull
    private final String title;
    @NotNull
    private final String content;


    public Article(@NotNull String title, @NotNull String content) {
        this.title = title;
        this.content = content;
    }


    @NotNull
    public String getTitle() {
        return title;
    }

    @NotNull
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return title + "\n" + content;
    }

    @NotNull
    public String getSearchableName() {
        return this.getClass().getSimpleName() + "-" + SEARCHABLE_CONTENT_KIND + "-" + this.hashCode();
    }

    @Override
    public @NotNull String getSearchableTerm() {
        return toString();
    }

    public static final String SEARCHABLE_CONTENT_KIND = "ARTICLE";

    @Override
    public @NotNull String getSearchableContentKind() {
        return SEARCHABLE_CONTENT_KIND;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

}