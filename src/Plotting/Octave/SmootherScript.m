% Access global variables
global x ySine yCosine

% Define the window size for smoothing
windowSize = 5;

% Apply sliding window smoothing to ySine
ySineSmoothed = zeros(1, length(ySine));
for i = 1:length(ySine)
    startIdx = max(1, i - floor(windowSize / 2));
    endIdx = min(length(ySine), i + floor(windowSize / 2));
    window = ySine(startIdx:endIdx);
    ySineSmoothed(i) = mean(window);
end

% Apply sliding window smoothing to yCosine
yCosineSmoothed = zeros(1, length(yCosine));
for i = 1:length(yCosine)
    startIdx = max(1, i - floor(windowSize / 2));
    endIdx = min(length(yCosine), i + floor(windowSize / 2));
    window = yCosine(startIdx:endIdx);
    yCosineSmoothed(i) = mean(window);
end

% Update the global variables with smoothed data
ySine = ySineSmoothed;
yCosine = yCosineSmoothed;

% Plot the smoothed sine and cosine waves
figure;
plot(x, ySine, 'b', 'DisplayName', 'Smoothed Sine');
hold on;
plot(x, yCosine, 'r', 'DisplayName', 'Smoothed Cosine');
legend;
title('Smoothed Salted Sine and Cosine Waves');
xlabel('X');
ylabel('Y');
grid on;

