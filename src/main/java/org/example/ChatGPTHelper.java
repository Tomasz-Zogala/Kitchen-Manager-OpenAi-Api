package org.example;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import java.time.Duration;
import java.util.List;

public class ChatGPTHelper {

    OpenAiService service;
    public ChatGPTHelper() {
        this.service = new OpenAiService("#MYTOKEN#", Duration.ofSeconds(30));
    }

    public String getBreakfastIdea(List<String> products) {
        String allProducts = String.join("' ", products);
        String question = "I have in fridge " + allProducts + ". What I can make for breakfast? Give me 3 ideas for this meal";

        return askChatGPT(question);
    }

    public String getDinnerIdea(List<String> products) {
        String allProducts = String.join("' ", products);
        String question = "I have in fridge " + allProducts + ". What I can make for dinner? Give me 3 ideas for this meal";

        return askChatGPT(question);
    }

    public String getHealthyProductsRecommendation(List<String> products){
        String allProducts = String.join("' ", products);
        String question = "I have in fridge " + allProducts + ". Give me other healthy food recommendations.";

        return askChatGPT(question);
    }

    private String askChatGPT(String question) {
        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                .messages(List.of(new ChatMessage("user", question)))
                .model("gpt-3.5-turbo")
                .build();
        List<ChatCompletionChoice> choices = service.createChatCompletion(completionRequest).getChoices();

        StringBuilder stringBuilder = new StringBuilder();

        choices.stream()
                .map(ChatCompletionChoice::getMessage)
                .map(ChatMessage::getContent)
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }
}
