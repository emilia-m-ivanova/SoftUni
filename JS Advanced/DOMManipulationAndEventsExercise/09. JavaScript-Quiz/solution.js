function solve() {
    const answers = ['onclick', 'JSON.stringify()', 'A programming API for HTML and XML documents'];
    const userAnswers = [];
    const output = document.querySelector('#results');
    const sections = Array.from(document.querySelectorAll('#quizzie>section'));
    sections.forEach((s, i) => {
        s.addEventListener("click", (ev) => onClick(ev, i, s));
    });

    function onClick(ev, i, section) {
        const element = ev.target;
        if (element.className === 'answer-text') {
            userAnswers.push(element.textContent);
            section.style.display = 'none';
            sections[i + 1] ?
                sections[i + 1].style.display = 'block' :
                getResult();

        }
    }

    function getResult() {
        let correctAnswers = userAnswers.map((e, i) => {
            return e === answers[i];
        }).filter(e => e === true);

        if (correctAnswers.length === 3) {
            output.querySelector('.results-inner h1').textContent = 'You are recognized as top JavaScript fan!';
        } else {
            output.querySelector('.results-inner h1').textContent = `You have ${correctAnswers.length} right answers`;
        }
        output.style.display = 'block';
    }
}
