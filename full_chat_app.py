import streamlit as st
import subprocess

st.set_page_config(page_title="eAssessment Bot", page_icon="🧠")
st.title("🧠 eAssessment Assistant")
if st.button("Clear Chat"):
    st.session_state.chat = []
    st.experimental_rerun()


# Initialize chat history
if "chat" not in st.session_state:
    st.session_state.chat = []

# Display conversation history
for message in st.session_state.chat:
    if message["role"] == "user":
        st.markdown(f"**You:** {message['content']}")
    else:
        st.markdown(f"**Assistant:** {message['content']}")

# Input box
user_input = st.text_input("Ask something related to eAssessment app:", key="input")

# Submit button
if st.button("Submit") and user_input.strip():
    # Add user message to history
    st.session_state.chat.append({"role": "user", "content": user_input})

    with st.spinner("Thinking..."):
        result = subprocess.run(
            ["ollama", "run", "eassessment-bot"],
            input=user_input.encode(),
            capture_output=True
        )
        response = result.stdout.decode()

    # Add bot response to history
    st.session_state.chat.append({"role": "bot", "content": response})

    # Rerun app to refresh the chat display
    st.experimental_rerun()
