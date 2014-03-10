<?php
prepareContent();

function prepareContent() {
    $stop_words = explode(",", file_get_contents('stop_words.txt'));
    $book_text = file_get_contents('pride-and-prejudice.txt');
    $book_text = strtolower($book_text);
    $book_text = str_replace("\n", " ", $book_text);
    $book_text = str_replace("-", " ", $book_text);
    $book_text = str_replace("'s", "", $book_text);
    $book_text = preg_replace("/[^a-zA-Z0-9 ]/", "", $book_text);
    $words = explode(" ", $book_text);
    countWords($words, $stop_words);
    echo "<br/>";
    countWords2($book_text, $stop_words);
}

function countWords($words, $stop_words) {
    $list = array();
    foreach ($words as $value) {
        if (in_array($value, $stop_words)) {
            continue;
        }
        if (!empty($list[$value])) {
            $list[$value] ++;
        }
        if (empty($list[$value])) {
            $list[$value] = 1;
        }
    }
    arsort($list);
    array_shift($list);
    $list = array_slice($list, 0, 25);
    echo "<b>Solution A</b><br/>";
    foreach ($list as $key => $val) {
        echo "$key => $val<br/>";
    }
}

function countWords2($book_text, $stop_words) {
    $words = array_count_values(str_word_count($book_text, 1));
    arsort($words);
    foreach ($words as $key => $value) {
        if (in_array($key, $stop_words))
            unset($words[$key]);
    }
    $words = array_slice($words, 0, 25);
    echo "<b>Solution B</b><br/>";
    foreach ($words as $key => $val) {
        echo "$key => $val<br/>";
    }
}