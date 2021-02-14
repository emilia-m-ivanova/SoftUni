function solve() {
    class Post {
        constructor(title, content) {
            this.title = title;
            this.content = content;
        }

        toString() {
            return `Post: ${this.title}\n` +
                `Content: ${this.content}`;
        }

    }

    class SocialMediaPost extends Post {
        constructor(title, content, likes, dislikes) {
            super(title, content);
            this.comments = [];
            this.likes = likes;
            this.dislikes = dislikes;
        }

        addComment(comment) {
            this.comments.push(comment);
        }

        toString() {
            return super.toString() +
                `\nRating: ${this.likes - this.dislikes}` +
                (this.comments.length > 0 ?
                    "\nComments:\n" + this.comments.map(e => ' * ' + e).join('\n') : '');
        }
    }

    class BlogPost extends Post {
        constructor(title, content,views) {
            super(title,content);
            this.views = views;
        }
        view(){
            this.views++;
            return this;
        }
        toString() {
            return super.toString() + `\nViews: ${this.views}`;
        }
    }

    return {Post, SocialMediaPost,BlogPost};
}