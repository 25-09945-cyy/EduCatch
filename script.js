let editingCard = null;

// main containers
const recordsContainer =
document.getElementById("recordsContainer");

const emptyState =
document.getElementById("emptyState");

//SCROLL

document
.getElementById("focusFormBtn")
.addEventListener(
    "click",
    function () {

        document
        .getElementById("recordFormArea")
        .scrollIntoView({
            behavior: "smooth"
        });

    }
);
//SAVE

document
.getElementById("recordForm")
.addEventListener(
    "submit",
    function (event) {

        event.preventDefault();

        // get values
        const subject =
        document.getElementById("subject").value;

        const topic =
        document.getElementById("topic").value;

        const assignment =
        document.getElementById("assignment").value;

        const classDate =
        document.getElementById("classDate").value;

        const deadline =
        document.getElementById("deadline").value;

        const notes =
        document.getElementById("notes").value;

        // hide empty state
        emptyState.style.display = "none";

        // create card
        const card =
        document.createElement("div");

        card.className = "record-card";

        // store edit and search values
        card.dataset.subject =
        subject.toLowerCase();

        card.dataset.topic =
        topic;

        card.dataset.assignment =
        assignment;

        card.dataset.classdate =
        classDate;

        card.dataset.deadline =
        deadline;

        card.dataset.notes =
        notes;

        // layout ng cards
        card.innerHTML = `
        <div class="card-actions">

            <button class="edit-btn">
                Edit
            </button>

            <button class="delete-btn">
                Delete
            </button>

        </div>

        <div class="card-header">

            <span class="badge">
                ${subject}
            </span>

            <span>
                ${classDate}
            </span>

        </div>

        <h2>
            ${topic}
        </h2>

        <p>
            <strong>Assignment:</strong>
            ${assignment || "None"}
        </p>

        <p>
            <strong>Deadline:</strong>
            ${deadline || "None"}
        </p>

        <p>
            <strong>Notes:</strong>
            ${notes || "None"}
        </p>
        `;

        // upd cards
        if (editingCard !== null) {

            editingCard.remove();

            editingCard = null;
        }

        // add card
        recordsContainer.appendChild(card);

        // enable btn
        attachDelete(card);
        attachEdit(card);

        this.reset();

    }
);

//DELETE

function attachDelete(card) {

    const deleteButton =
    card.querySelector(".delete-btn");

    deleteButton.addEventListener(
        "click",
        function () {

            const answer =
            confirm(
                "Delete this record?"
            );

            if (!answer) {
                return;
            }

            card.remove();

            const cards =
            document.querySelectorAll(
                ".record-card"
            );

            if (cards.length === 0) {

                emptyState.style.display =
                "block";
            }

        }
    );

}

//EDIT

function attachEdit(card) {

    const editButton =
    card.querySelector(".edit-btn");

    editButton.addEventListener(
        "click",
        function () {

            editingCard = card;

            document
            .getElementById("subject")
            .value =
            card.dataset.subject;

            document
            .getElementById("topic")
            .value =
            card.dataset.topic;

            document
            .getElementById("assignment")
            .value =
            card.dataset.assignment;

            document
            .getElementById("classDate")
            .value =
            card.dataset.classdate;

            document
            .getElementById("deadline")
            .value =
            card.dataset.deadline;

            document
            .getElementById("notes")
            .value =
            card.dataset.notes;

            document
            .getElementById("recordFormArea")
            .scrollIntoView({
                behavior: "smooth"
            });

        }
    );

}

// SEARCH
document
.getElementById("searchBtn")
.addEventListener(
    "click",
    function () {

        const searchText =
        document
        .getElementById("searchInput")
        .value
        .toLowerCase();

        const selectedDate =
        document
        .getElementById("dateFilter")
        .value;

        const cards =
        document.querySelectorAll(
            ".record-card"
        );

        cards.forEach(card => {

            const subjectMatch =
            card.dataset.subject
            .includes(searchText);

            const dateMatch =

            selectedDate === ""

            ||

            card.dataset.classdate
            === selectedDate;

            if (
                subjectMatch &&
                dateMatch
            ) {

                card.style.display =
                "block";

            } else {

                card.style.display =
                "none";
            }

        });

    }
);
