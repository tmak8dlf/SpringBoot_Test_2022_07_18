package com.mysite.sbb.Article.ArticleService;

import com.mysite.sbb.Article.dao.ArticleRepository;
import com.mysite.sbb.Article.domain.Article;
import com.mysite.sbb.util.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
  @Autowired
  private ArticleRepository articleRepository;

  public List<Article> getList() {
    return articleRepository.findAll();
  }

  public Article getArticle(Integer id) {
    Optional<Article> article = this.articleRepository.findById(id);
    if (article.isPresent()) {
      return article.get();
    } else {
      throw new DataNotFoundException("article not found");
    }
  }
}