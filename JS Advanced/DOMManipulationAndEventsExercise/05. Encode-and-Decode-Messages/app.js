function encodeAndDecodeMessages() {
    const [encodeBtn,decodeBtn] = Array.from(document.querySelectorAll('button'));
    const [inputText, outputText] = Array.from(document.querySelectorAll('textarea'));
    encodeBtn.addEventListener('click',encode);
    decodeBtn.addEventListener('click',decode);

    function encode() {
        let text = inputText.value;
        let encoded = '';
        for (let char of text) {
            encoded += String.fromCharCode(char.charCodeAt(0) + 1);
        }
        outputText.value = encoded;
        inputText.value = '';
    }

    function decode() {
        let text = outputText.value;
        let decoded = '';
        for (let char of text) {
            decoded += String.fromCharCode(char.charCodeAt(0) - 1);
        }
        outputText.value = decoded;
    }
}