function extractText() {
    const elements = Array.from(document.getElementsByTagName('li'));
    const textFromList = elements.map(e => e.textContent);
    document.getElementById('result').textContent = textFromList.join('\n');
}