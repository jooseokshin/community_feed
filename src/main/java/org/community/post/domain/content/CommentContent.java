package org.community.post.domain.content;

public class CommentContent extends Content{

    private static final int MAX_POS_LENGTH = 100;

    public CommentContent(String content) {
        super(content);
    }

    @Override
    protected void checkText(String contentText) {
        if(contentText == null || contentText.length() > MAX_POS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
