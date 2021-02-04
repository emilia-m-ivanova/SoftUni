function solve(deck) {

    const result = deck.map(card => {
        try {
            const f = card.slice(0, -1);
            const s = card.slice(card.length-1);
            return createCard(f, s);
        } catch (error) {
            return 'Invalid card: ' + card;
        }
    });
    console.log(result.join(' '));

    function createCard(face, suit) {
        const validFaces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
        const validSuits = {
            S: '\u2660',
            H: '\u2665',
            D: '\u2666',
            C: '\u2663',
        }

        if (!validFaces.includes(face) || !Object.keys(validSuits).includes(suit)) {
            throw new Error('Invalid input');
        }

        return {
            face,
            suit,
            toString: () => {
                return face + validSuits[suit]
            },
        }
    }
}

console.log(solve(['AS', '10D', 'KH', '2C']));
