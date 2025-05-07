package functionalProgramming.level9.A47;

import java.util.*;
import java.util.stream.Collectors;

public class CommentCounter {
    public static void main(String[] args) {
        List<Comment> comments = Arrays.asList(
                new Comment("Alice", "Nice post!"),
                new Comment("Bob", "Interesting..."),
                new Comment("Alice", "Thanks for sharing."),
                new Comment("Charlie", "Great content!"),
                new Comment("Bob", "I agree."),
                new Comment("Alice", "Loved it.")
        );

        Map<String, Long> commentCountByUser = comments.stream()
                .collect(Collectors.groupingBy(
                        Comment::getUser,
                        Collectors.counting()
                ));

        commentCountByUser.forEach((user, count) ->
                System.out.println(user + " made " + count + " comment")
        );
    }
}
