package com.mysite.sbb.Reply.controller;

import com.mysite.sbb.Reply.Service.ReplyService;
import com.mysite.sbb.Article.ArticleService.ArticleService;
import com.mysite.sbb.Article.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
  private final ArticleService articleService;
  private final ReplyService replyService;
  @PostMapping("/create/{id}")
  public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
    Article article = this.articleService.getArticle(id);
    this.replyService.create(article, content);
    return String.format("redirect:/question/detail/%s", id);
  }
}