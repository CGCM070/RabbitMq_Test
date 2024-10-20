// document.addEventListener('DOMContentLoaded', () => {
//     const messageContainer = document.getElementById('message-container');
//     const messageInput = document.getElementById('message-input');
//     const sendButton = document.getElementById('send-button');
//
//     // Conectar a WebSocket
//     const socket = new WebSocket('ws://localhost:8080/ws');
//
//     // Manejar la conexión abierta
//     socket.addEventListener('open', () => {
//         console.log('WebSocket connected');
//     });
//
//     // Enviar mensaje al hacer clic en el botón
//     sendButton.addEventListener('click', () => {
//         const message = messageInput.value;
//         if (message.trim() !== "") {
//             // Crear objeto JSON para enviar
//             const messagePayload = {
//                 content: message,
//                 sender: "Usuario"  // Aquí podrías agregar el nombre del usuario autenticado
//             };
//
//             // Envía el objeto JSON como string
//             socket.send(JSON.stringify(messagePayload));
//
//             messageInput.value = "";  // Limpia el campo de texto
//         }
//     });
//
//     // Manejar mensajes recibidos
//     socket.addEventListener('message', event => {
//         const messageData = JSON.parse(event.data);  // Suponemos que recibimos un JSON
//         const messageElement = document.createElement('div');
//
//         // Mostrar el contenido del mensaje y el remitente
//         console.log(`Message from ${messageData.sender}: ${messageData.content}`);
//         messageElement.textContent = `${messageData.sender}: ${messageData.content}`;
//
//         messageContainer.appendChild(messageElement);
//         messageContainer.scrollTop = messageContainer.scrollHeight;  // Scroll hacia abajo automáticamente
//     });
//
//     // Manejar errores
//     socket.addEventListener('error', (error) => {
//         console.error('WebSocket error:', error);
//     });
//
//     // Manejar el cierre de la conexión
//     socket.addEventListener('close', () => {
//         console.log('WebSocket closed');
//     });
// });


document.addEventListener('DOMContentLoaded', () => {
    const messageContainer = document.getElementById('message-container');
    const messageInput = document.getElementById('message-input');
    const sendButton = document.getElementById('send-button');

    // Conectar a WebSocket
    const socket = new WebSocket('ws://localhost:8080/ws');

    // Manejar la conexión abierta
    socket.addEventListener('open', () => {
        console.log('WebSocket connected');
    });

    // Enviar mensaje al hacer clic en el botón
    sendButton.addEventListener('click', () => {
        const message = messageInput.value;
        if (message.trim() !== "") {
            // Envía el mensaje como texto plano
            socket.send(message);

            messageInput.value = "";  // Limpia el campo de texto
        }
    });

    // Manejar mensajes recibidos
    socket.addEventListener('message', event => {
        const message = event.data;  // Recibimos el mensaje como texto plano
        const messageElement = document.createElement('div');

        // Mostrar el contenido del mensaje
        messageElement.textContent = message;

        messageContainer.appendChild(messageElement);
        messageContainer.scrollTop = messageContainer.scrollHeight;  // Scroll hacia abajo automáticamente
    });

    // Manejar errores
    socket.addEventListener('error', (error) => {
        console.error('WebSocket error:', error);
    });

    // Manejar el cierre de la conexión
    socket.addEventListener('close', () => {
        console.log('WebSocket closed');
    });
});
