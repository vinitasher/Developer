/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vasher we have a table with comments in it.  *
 * Each row in the comment table has an id and a parentId.  *
 * We want to take that list of comments and convert it to a nested  *
 * form the front end will use to display it.  *
 *
 *
 *
 *
 * Write a function that takes a list of RawComment objects  *
 * and returns a list of nested Comment objects.
 *
 *
 *
 * RawComment(id: Long, text: String, parentId: Long)
 *
 * Comment(id: Long, text: String, children: List[Comment])
 */
public class CommentTable {

    public class RawComment {

        Long id;
        String text;
        Long parentId;

        public RawComment(Long id, String text, Long parentId) {
            this.id = id;
            this.text = text;
            this.parentId = parentId;
        }
    }

    public class Comment {

        Long id;
        String text;
        List<Comment> children;

        public Comment(Long id) {
            this.id = id;
            this.children = new ArrayList<>();
        }

        public Comment(Long id, String text) {
            this.id = id;
            this.text = text;
            this.children = new ArrayList<>();
        }

        public boolean equals(Comment c) {
            return this.id.equals(c.id);
        }

        public String toString() {
            return this.id + " " + this.text;
        }
    }

    public List<Comment> convertComments(List<RawComment> comments) {
        HashMap<Long, Comment> commentMap = new HashMap<>();
        for (RawComment rawComment : comments) {
            if (rawComment.parentId == null && commentMap.containsKey(
                    rawComment.id)) {
                Comment c = commentMap.get(rawComment.id);
                c.text = rawComment.text;
            } else if (rawComment.parentId == null && !commentMap.containsKey(
                    rawComment.id)) {
                Comment c = new Comment(rawComment.id, rawComment.text);
                commentMap.put(c.id, c);
            } else if (rawComment.parentId != null && commentMap.containsKey(
                    rawComment.parentId)) {
                if (!commentMap.containsKey(rawComment.id)) {
                    Comment c = new Comment(rawComment.id, rawComment.text);
                    commentMap.get(rawComment.parentId).children.add(c);
                } else {
                    Comment c = commentMap.remove(rawComment.id);
                    c.text = rawComment.text;
                    commentMap.get(rawComment.parentId).children.add(c);
                }
                Comment c = new Comment(rawComment.id, rawComment.text);
                commentMap.get(rawComment.parentId).children.add(c);
            } else {
                Comment c = new Comment(rawComment.parentId);
                if (!commentMap.containsKey(rawComment.id)) {
                    c.children.add(new Comment(rawComment.id, rawComment.text));
                    commentMap.put(c.id, c);
                } else {
                    c.children.add(commentMap.remove(rawComment.id));
                    commentMap.put(c.id, c);
                }
            }
        }
        List<Comment> results = new ArrayList<>();
        for (Map.Entry<Long, Comment> entry : commentMap.entrySet()) {
            results.add(entry.getValue());
        }
        return results;
    }

    public static void main(String[] args) {
        CommentTable ct = new CommentTable();
        List<RawComment> rcl = new ArrayList<>();
        rcl.add(ct.new RawComment(123L, "p6", 999L));
        rcl.add(ct.new RawComment(234L, "p5", 999L));
        rcl.add(ct.new RawComment(345L, "p4", 888L));
        rcl.add(ct.new RawComment(456L, "p3", 777L));
        rcl.add(ct.new RawComment(999L, "p2", 111L));
        rcl.add(ct.new RawComment(888L, "p1", 111L));
        rcl.add(ct.new RawComment(777L, "p0", 111L));
        rcl.add(ct.new RawComment(111L, "p7", null));
        System.out.println(ct.convertComments(rcl));
    }
}
