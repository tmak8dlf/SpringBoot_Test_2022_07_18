package com.mysite.sbb.Reply.Service;

import com.mysite.sbb.Reply.dao.ReplyRepository;
import com.mysite.sbb.Reply.domain.Reply;
import com.mysite.sbb.Article.domain.Article;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ReplyService {
  private final ReplyRepository replyRepository;

  public void create(Article article, String content){
    Reply reply = new Reply();
    reply.setContent(content);
    reply.setCreateDate(LocalDateTime.now());
    reply.setArticle(article);
    this.replyRepository.save(reply);
  }
}
