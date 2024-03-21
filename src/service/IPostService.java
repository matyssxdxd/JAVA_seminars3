package service;

import model.Post;
import model.PostType;

public interface IPostService {
    Post publishPost(PostType type, String msg) throws Exception;
}
