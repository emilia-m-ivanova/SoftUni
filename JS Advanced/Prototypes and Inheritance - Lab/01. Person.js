function Person(first, last) {
    this.firstName = first;
    this.lastName = last;
    Object.defineProperty(this, "fullName", {
            set: function (value) {
                const [firstName, lastName] = value.split(' ');
                if (!lastName) {
                    return;
                }
                this.firstName = firstName;
                this.lastName = lastName;
            },
            get: function () {
                return this.firstName + ' ' + this.lastName;
            }
        }
    );
}
