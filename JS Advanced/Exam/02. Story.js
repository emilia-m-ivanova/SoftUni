class Story {
    constructor(title, creator) {
        this.title = title;
        this.creator = creator;
        this._comments = [];
        this._likes = []
    }

    get likes() {
        if (this._likes.length === 0) {
            return `${this.title} has 0 likes`
        }
        if (this._likes.length === 1) {
            return `${this._likes[0]} likes this story!`;
        }

        return `${this._likes[0]} and ${this._likes.length - 1} others like this story!`
    }

    like(username) {
        if (this._likes.some(e => e === username)) {
            throw new Error('You can\'t like the same story twice!');
        }
        if (this.creator === username) {
            throw new Error('You can\'t like your own story!');
        }
        this._likes.push(username);

        return `${username} liked ${this.title}!`
    }

    dislike(username) {
        if (!this._likes.find(e => e === username)) {
            throw new Error('You can\'t dislike this story!');
        }
        this._likes = this._likes.filter(e => e !== username);
        return `${username} disliked ${this.title}`
    }

    comment(username, content, id) {
        if (id === undefined || !this._comments.find(e => e.id === id)) {
            let id;
            if(this._comments.length===0){
                id=1;
            }else{
                id = this._comments[this._comments.length-1].id + 1;
            }
            this._comments.push({id: id, username, content, replies: []})
            return `${username} commented on ${this.title}`
        }
        const comment = this._comments.find(e => e.id === id);
        const replyId = comment.replies.length === 0 ? 1 :
            comment.replies[comment.replies.length - 1].id + 1;
        comment.replies.push({id: replyId, username, content})
        return `You replied successfully`;

    }

    toString(sortingType) {
        const sort = {
            asc: function (a, b) {
                return a.id - b.id;
            },
            desc: function (a, b) {
                return b.id - a.id;
            },
            username: function (a, b) {
                return a.username.localeCompare(b.username);
            }
        }

        return (`Title: ${this.title}\n` +
            `Creator: ${this.creator}\n` +
            `Likes: ${this._likes.length}\n` +
            `Comments:\n` +
            this._comments.sort(sort[sortingType])
                .map(e => {
                    return `-- ${e.id}. ${e.username}: ${e.content}` +
                        (e.replies.length > 0 ? '\n' +
                            e.replies.sort(sort[sortingType])
                                .map(r => {
                                    return `--- ${e.id + '.' + r.id}. ${r.username}: ${r.content}`
                                }).join('\n') : '');
                }).join('\n')).trim();

    }

}

let story = new Story('Story','Emi');
console.log(story.toString());
// let art = new Story("My Story", "Anny");
// art.like("John");
// console.log(art.likes);
// art.dislike("John");
// console.log(art.likes);
// art.comment("Sammy", "Some Content");
// console.log(art.comment("Ammy", "New Content"));
// art.comment("Zane", "Reply", 1);
// art.comment("Jessy", "Nice :)");
// console.log(art.comment("SAmmy", "Reply@", 1));
// console.log(art.comment("SAmmy", "Reply@", 1));
// console.log(art.comment("SAmmy", "Reply@", 1));
// console.log(art.comment("SAmmy", "Reply@", 1));
// console.log(art.comment("SAmmy", "Reply@", 1));
// console.log(art.comment("SAmmy", "Reply@", 1));
// console.log(art.comment("SAmmy", "Reply@", 1));
// console.log(art.comment("SAmmy", "Reply@", 1));
// console.log(art.comment("SAmmy", "Reply@", 1));
// console.log(art.comment("SAmmy", "Reply@", 1));
// console.log(art.comment("SAmmy", "Reply@", 1));
//
// console.log()
// console.log(art.toString('username'));
// console.log()
// art.like("Zane");
// console.log(art.toString('desc'));
// console.log();
// console.log(art.toString('asc'));