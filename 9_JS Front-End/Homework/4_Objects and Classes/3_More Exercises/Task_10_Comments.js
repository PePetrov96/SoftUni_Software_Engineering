function solve(input) {
    function fillArticlesWithComments(input) {
        let outputMap = new Map();

        let users = [];
        let articles = [];


        for (let line of input) {

            let tokens = line.split(' ');
            let command = tokens.shift();
            let name = tokens.join(' ');

            if (command === 'user') {
                users.push(name);
            } else if (command === 'article') {
                articles.push(name);
            } else {
                let tokens = line.split(' posts on ');
                let articleInfo = tokens[1].split(': ');
                let articleContent = articleInfo[1].split(', ');

                let username = tokens[0];
                let articleName = articleInfo[0];
                let articleTitle = articleContent[0];
                let articleComment = articleContent[1];

                if (users.includes(username) && articles.includes(articleName)) {
                    if (!outputMap.has(articleName)) {
                        outputMap.set(articleName, [{username: username, title: articleTitle, content: articleComment}]);
                    } else {
                        outputMap.get(articleName).push({username: username, title: articleTitle, content: articleComment});
                    }
                }
            }
        }
        return outputMap;
    }

    let articleComments = fillArticlesWithComments(input);

    function sortAndPrint(articles) {
        const sortedArticles = new Map([...articles.entries()].sort((a, b) => {
            const commentsCountA = a[1].length;
            const commentsCountB = b[1].length;

            return commentsCountB - commentsCountA;
        }));

        sortedArticles.forEach((comments, article) => {
            console.log(`Comments on ${article}`);

            comments.sort((a,b) => a.username.localeCompare(b.username));

            comments.forEach(comment => console.log(`--- From user ${comment.username}: ${comment.title} - ${comment.content}`));
        });

    }

    sortAndPrint(articleComments);
}

solve(['user aUser123', 'someUser posts on someArticle: NoTitle, stupidComment',
    'article Books', 'article Movies', 'article Shopping', 'user someUser', 'user uSeR4', 'user lastUser',
    'uSeR4 posts on Books: I like books, I do really like them',
    'uSeR4 posts on Movies: I also like movies, I really do',
    'someUser posts on Shopping: title, I go shopping every day',
    'someUser posts on Movies: Like, I also like movies very much']);

solve(['user Mark', 'Mark posts on someArticle: NoTitle, stupidComment', 'article Bobby', 'article Steven',
    'user Liam', 'user Henry', 'Mark posts on Bobby: Is, I do really like them',
    'Mark posts on Steven: title, Run', 'someUser posts on Movies: Like']);