package org.community.post.domain.content;

public class PostContent extends Content {

    private static final int MIN_POS_LENGTH = 5;
    private static final int MAX_POS_LENGTH = 500;

    public PostContent(String content) {
        super(content);
    }

    @Override
    protected void checkText(String contentText) {
        if(contentText == null || contentText.length() < MIN_POS_LENGTH  || contentText.length() > MAX_POS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

}
