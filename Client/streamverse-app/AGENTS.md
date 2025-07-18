Product Requirements Document: StreamVerse Frontend

1. Project Overview

This document outlines the requirements for building the frontend of StreamVerse, a live streaming and VOD platform. The frontend will be a web application built with Next.js and will interact with a separate Java/MongoDB backend API.

The goal of the MVP (Minimum Viable Product) is to deliver the core user journey: a creator can log in and find their stream key, and a viewer can see live streams and watch them with a real-time chat.

2.  Core Technology & Principles

    Framework: Next.js 14+ (using the App Router).

    Language: TypeScript.

    Styling: Tailwind CSS for all custom styling.

    Color Palette: The UI should adhere to the following color scheme. These colors are based on the default Tailwind CSS palette for easy implementation.

    Primary Action (Blue): #3B82F6 (blue-500) - Used for primary buttons, links, and active state indicators.

    Accent (Violet): #8B5CF6 (violet-500) - Used for highlights, notifications, and special call-to-actions.

    Background (Dark): #111827 (gray-900) - The main background color for the application body.

    UI Surface (Gray): #1F2937 (gray-800) - Used for Card components and other container backgrounds.

    Text (Primary): #F9FAFB (gray-50) - For main headings and body text.

    Text (Secondary): #9CA3AF (gray-400) - For descriptions, labels, and less prominent text.

    Component Library: shadcn/ui. All UI elements like buttons, inputs, and cards must be built using this library.

    State Management:

        Global State: Use React Context for managing global authentication status and user data.

        Local State: Use the useState and useReducer hooks for component-level state (e.g., form inputs, loading toggles).

    API Communication:

        Create a centralized API client (using axios or a fetch wrapper) to handle all requests to the backend.

        The base URL for the backend API will be stored in an environment variable (NEXT_PUBLIC_API_URL).

    Authentication:

        The frontend is stateless regarding authentication tokens.

        The Java backend will set a secure, httpOnly cookie containing a JWT upon successful login.

        The browser will automatically send this cookie with subsequent API requests.

        An AuthContext will hold user data (e.g., {id, username, email}) fetched from a /api/auth/me endpoint to confirm the session.

3.  shadcn/ui Components

These will be the primary building blocks for the UI.

    Button

    Input

    Card (and its sub-components: CardHeader, CardContent, CardFooter, CardTitle, CardDescription)

    Label

    Avatar (and AvatarImage, AvatarFallback)

    Alert (and AlertTitle, AlertDescription)

    Toast (and Toaster, useToast)

    Skeleton

4. Page & Feature Requirements

This section details each page (route) of the application.
4.1. Layout and Global Components

    File: app/layout.tsx

    Requirements:

        Set up the root layout with the Inter font, Tailwind CSS base styles, and the Toaster component from shadcn/ui.

        Implement a persistent Header component.

        Header Logic:

            If the user is not authenticated, show "Login" and "Register" buttons.

            If the user is authenticated, show a link to the "Dashboard" and a user Avatar with a dropdown menu (for "Logout").

        Wrap the page content with the AuthProvider (from the AuthContext).

4.2. Authentication Pages (/login, /register)

    Route: /login and /register

    Purpose: Allow users to sign in or create a new account.

    Layout & Components:

        The page should have a dark background.

        Use a Card component centered on the page.

        CardHeader: Contains CardTitle ("Login" or "Register") and CardDescription.

        CardContent: Contains a form with Input fields and Labels (Email, Password for login; Username, Email, Password for register).

        CardFooter: Contains the main action Button ("Sign In" or "Create Account").

    User Interaction & Logic:

        All form fields are required and should have basic validation.

        On button click, show a loading state on the button.

        Call the respective backend API endpoint (/api/auth/login or /api/auth/register).

        On Success:

            Use the useToast hook to show a success message (e.g., "Login successful!").

            Redirect the user to the /dashboard page.

        On Error:

            Display an Alert component inside the card with the error message returned from the API.

4.3. Home Page (/)

    Route: /

    Purpose: Display a list of all currently live streams for discovery.

    Data Fetching:

        This should be a Server Component.

        It must fetch data from the public GET /api/streams/live endpoint.

    Layout & Components:

        Display a title like "Live Streams".

        Render the streams in a responsive grid.

        Navigation Bar (10% height): Logo left side, Profile account on the
        right side

        Left Column (10% width): Side Bar

        Right Column (90% width): Main content

        If no streams are live, display a message like "No one is live right now. Check back later!"

        Stream Card Component:

            Each item in the grid is a Card component that links to /stream/[channelName].

            The card should display the stream's thumbnail (placeholder for now), the stream title, and the channel name.

            Use a Skeleton component for each card while the page is loading.

4.4. Creator Dashboard (/dashboard)

    Route: /dashboard

    Purpose: Provide the creator with the necessary information to start streaming.

    Security: This is a protected route. If a non-authenticated user tries to access it, they must be redirected to /login.

    Data Fetching:

        This is a Client Component ('use client').

        It must fetch data from the secure GET /api/channel/me endpoint.

    Layout & Components:

        Display a title: "Creator Dashboard".

        Use a Card to display the "Stream Information".

        Stream Key:

            Display the stream key in a read-only Input field.

            Place a Button next to it with a "Copy" icon. Clicking it copies the key to the clipboard and shows a "Copied!" Toast.

        Stream URL:

            Display the RTMP ingest URL (e.g., rtmp://your-server/live).

        Stream Title:

            Include an Input field to allow the creator to update their stream title.

            A "Save" Button will send a PUT or PATCH request to an endpoint like /api/channel/me to update the title.

4.5. Stream Viewing Page (/stream/[channelName])

    Route: /stream/[channelName] (dynamic route)

    Purpose: Allow viewers to watch a live stream and participate in real-time chat.

    Layout & Components:

        This page must use a two-column layout on desktop screens.

        Left Column (70% width): The video player section.

        Right Column (30% width): The real-time chatbox.

        Responsiveness: On mobile screens, the layout must stack vertically (video player on top, chatbox below).

    Video Player Component:

        This is a Client Component.

        Use the react-player library to play the HLS stream URL.

        The player should be configured to be responsive (width: '100%', height: '100%').

    Chatbox Component:

        This is a Client Component.

        State: const [messages, setMessages] = useState<ChatMessage[]>([]);

        WebSocket Logic:

            Use a useEffect hook to establish a WebSocket connection to the backend (e.g., ws://<api-url>/ws/chat/{channelName}) when the component mounts.

            The useEffect must have a listener for incoming messages. When a message is received, it should be added to the messages array.

            The useEffect must have a cleanup function to close the WebSocket connection when the component unmounts.

        UI:

            A scrollable area to display the list of messages. Each message should show the sender's username and the message content.

            An Input field at the bottom for the user to type their message.

            A Button to send the message, which calls the send method on the WebSocket instance.
