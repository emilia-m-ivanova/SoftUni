function calculate (numOfSteps, footLength, speedKm){
    const lengthInM = numOfSteps*footLength;
    const breaks = Math.floor(lengthInM/500);
    let timeInSeconds = ((lengthInM/1000)/speedKm) * 3600 + (breaks*60);
    const hours = Math.floor(timeInSeconds/3600);
    timeInSeconds-=hours*3600;
    const minutes = Math.floor(timeInSeconds/60);
    timeInSeconds-=minutes*60;
    return `${String(hours).padStart(2,'0')}:${String(minutes)
        .padStart(2,'0')}:${Math.round(timeInSeconds).toString().padStart(2,'0')}`
}
