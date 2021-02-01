function solve(...variables) {
    function varTypes() {
        const types = {};

        function getType(variable) {
            types[typeof variable] = types[typeof variable] ? types[typeof variable] + 1 : 1;
            console.log(`${typeof variable}: ${variable}`);
        }

        return {types, getType};
    }

    const statistics = varTypes();
    variables.forEach(e => statistics.getType(e));
    Object.entries(statistics.types).sort((a, b) => b[1] - a[1])
        .map(e => e[0] + ' = ' + e[1])
        .forEach(e => console.log(e));
}

solve(42, 'cat', 15, 'kitten', 'tomcat');