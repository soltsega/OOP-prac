const form = document.querySelector("#contact-form");
const contactsElement = document.querySelector("#contacts");
const countElement = document.querySelector("#count");
const messageElement = document.querySelector("#message");

async function loadContacts() {
    const response = await fetch("/api/contacts");
    const contacts = await response.json();
    renderContacts(contacts);
}

function renderContacts(contacts) {
    countElement.textContent = `${contacts.length} saved`;

    if (contacts.length === 0) {
        contactsElement.className = "contacts empty";
        contactsElement.innerHTML = "<p>No contacts yet.</p>";
        return;
    }

    contactsElement.className = "contacts";
    contactsElement.innerHTML = contacts.map(contact => `
        <article class="contact-card">
            <strong>${escapeHtml(contact.name)}</strong>
            <span>${escapeHtml(contact.email)}</span>
            <span>${escapeHtml(contact.phone)}</span>
        </article>
    `).join("");
}

function showMessage(text, type) {
    messageElement.textContent = text;
    messageElement.className = `message ${type}`;
}

function escapeHtml(value) {
    return String(value)
        .replaceAll("&", "&amp;")
        .replaceAll("<", "&lt;")
        .replaceAll(">", "&gt;")
        .replaceAll('"', "&quot;")
        .replaceAll("'", "&#039;");
}

form.addEventListener("submit", async event => {
    event.preventDefault();

    const formData = new FormData(form);
    const contact = {
        name: formData.get("name").trim(),
        email: formData.get("email").trim(),
        phone: formData.get("phone").trim()
    };

    try {
        const response = await fetch("/api/contacts", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(contact)
        });

        if (!response.ok) {
            const error = await response.json();
            throw new Error(error.message || error.detail || "Could not save contact.");
        }

        form.reset();
        showMessage("Contact added successfully.", "success");
        await loadContacts();
    } catch (error) {
        showMessage(error.message, "error");
    }
});

loadContacts();
