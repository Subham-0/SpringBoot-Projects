let stompClient = null;
let username = null;

function connect() {
    const socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function () {
        document.getElementById('messageInput').disabled = false;
        document.getElementById('sendMessage').disabled = false;

        stompClient.subscribe('/topic/messages', function (message) {
            showMessage(JSON.parse(message.body));
        });
    });
}

function showMessage(message) {
    const chat = document.getElementById('chat');
    const messageElement = document.createElement('div');

    if (message.sender === username) {
        messageElement.className = "message my-message";
    } else {
        messageElement.className = "message other-message";
    }

    messageElement.textContent = message.sender + ": " + message.content;
    chat.appendChild(messageElement);
    chat.scrollTop = chat.scrollHeight;
}

function sendMessage() {
    const content = document.getElementById('messageInput').value.trim();
    if (content === "") return;

    const chatMessage = {
        sender: username,
        content: content
    };

    stompClient.send("/app/sendMessage", {}, JSON.stringify(chatMessage));
    document.getElementById('messageInput').value = '';
}

document.getElementById('sendMessage').onclick = sendMessage;
document.getElementById('messageInput').addEventListener("keypress", function (e) {
    if (e.key === "Enter") {
        sendMessage();
    }
});

// Modal Handling
const usernameModal = new bootstrap.Modal(document.getElementById('usernameModal'));
usernameModal.show();

document.getElementById('setUsernameBtn').onclick = function () {
    const name = document.getElementById('usernameInput').value.trim();
    if (name) {
        username = name;
        usernameModal.hide();
        connect();
    }
};
