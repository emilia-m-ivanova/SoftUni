function solution(arg) {
    const patcher = {
        upvote: () => this.upvotes += 1,
        downvote: () => this.downvotes += 1,
        score: () => {
            let up = this.upvotes;
            let down = this.downvotes;
            if (up + down > 50) {
                const add = Math.ceil(Math.max(up, down) * 25 / 100);
                up += add;
                down += add;
            }
            let score = up - down;
            let rating;

            const percentPositive = this.upvotes / (this.upvotes + this.downvotes) * 100;
            const totalVotes = this.upvotes + this.downvotes;
            if (percentPositive > 66 && totalVotes >= 10) {
                rating = 'hot'
            } else if (score < 0 && totalVotes>=10) {
                rating = 'unpopular'
            } else if ((this.upvotes>100||this.downvotes>100)) {
                rating = 'controversial'
            } else {
                rating = 'new';
            }
            return [up, down, score, rating];
        }
        ,
    }
    return patcher[arg]();
}
let post = {
    id: '3',
    author: 'emil',
    content: 'wazaaaaa',
    upvotes: 100,
    downvotes: 100
};
solution.call(post, 'upvote');
solution.call(post, 'downvote');
let score = solution.call(post, 'score'); // [127, 127, 0, 'controversial']
solution.call(post, 'downvote');       // (executed 50 times)
console.log(solution.call(post, 'score'));     // [139, 189, -50, 'unpopular']