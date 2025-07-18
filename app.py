import streamlit as st
import subprocess

st.set_page_config(page_title="eAssessment Bot", page_icon="🧠")
st.title("🧠 eAssessment Assistant")

# Input box for user query
user_input = st.text_input("Ask something related to eAssessment app:")

# When user submits a question
if st.button("Submit") and user_input.strip():
    with st.spinner("Thinking..."):
        # Call your Ollama model (make sure it's created and available)
        result = subprocess.run(
            ["ollama", "run", "eassessment-bot"],
            input=user_input.encode(),
            capture_output=True
        )
        response = result.stdout.decode()

        # Show response
        st.markdown("**Assistant:**")
        st.write(response)
