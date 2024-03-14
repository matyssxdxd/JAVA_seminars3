package service;

import model.PostType;

public interface IPostService {
    void publishPost(PostType type, String msg) throws Exception;
}
