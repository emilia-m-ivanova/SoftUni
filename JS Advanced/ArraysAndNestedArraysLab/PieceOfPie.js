function solve(arr, flavour1, flavour2) {
    let result = arr
        .slice(arr.indexOf(flavour1), arr.indexOf(flavour2) + 1);
    return result;
}