document.addEventListener('DOMContentLoaded', () => {
    const messageContainer = document.getElementById('message-container');
    const messageInput = document.getElementById('message-input');
    const sendButton = document.getElementById('send-button');

    // Conectar a WebSocket
    const socket = new WebSocket('ws://localhost:8080/messages');

    // Enviar mensaje al hacer clic en el botón
    sendButton.addEventListener('click', () => {
        const message = messageInput.value;
        if (message.trim() !== "") {
            socket.send(message);  // Envía el mensaje al WebSocket
            messageInput.value = "";  // Limpia el campo de texto
        }
    });

    // Mostrar los mensajes recibidos
    socket.addEventListener('message', event => {
        const message = event.data;
        const messageElement = document.createElement('div');
        messageElement.textContent = message;
        messageContainer.appendChild(messageElement);
        messageContainer.scrollTop = messageContainer.scrollHeight;  // Scroll hacia abajo automáticamente
    });
});
