;(function(window) {

  var svgSprite = '<svg>' +
    '' +
    '<symbol id="icon-play-times" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M832 128 192 128c-35.3408 0-64 28.6592-64 64l0 640c0 35.3408 28.6592 64 64 64l640 0c35.3472 0 64-28.6592 64-64L896 192C896 156.6592 867.3472 128 832 128zM800 800 224 800 224 224l576 0L800 800zM428.8 364.8 633.6 512 428.8 659.2Z"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-uploadfailed" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M820.096 680.4096 571.4752 259.1296c-26.56-44.3904-92.96-44.3904-119.5264 0l-247.8784 421.28c-26.56 44.3904-8.2624 117.7472 44.864 117.7472l525.5552 0C827.6032 798.1632 846.656 724.8 820.096 680.4096zM516.1088 384.7424c15.6672 0 25.344 18.8992 23.9616 35.9488l-17.5104 198.1632-13.824 0-15.6672-198.1632C492.1408 404.096 501.3568 384.7424 516.1088 384.7424zM517.4848 699.0336c-14.2848 0-25.8048-11.52-25.8048-25.8048 0-14.2784 11.52-25.8048 25.8048-25.8048s25.8048 11.5264 25.8048 25.8048C543.296 687.5136 531.776 699.0336 517.4848 699.0336z"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-moveup" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M865.1904 569.8432l-214.0864 0c12.768 17.9904 18.5664 33.4144 17.4272 46.3104-0.1664 1.8048-0.4608 3.5776-0.8896 5.2736-3.712 14.6304-15.9616 21.5424-36.7616 20.7296-12.6272 0-28.9728 0.4096-49.024 1.2288-20.0512 0.7936-36.7616 1.2032-50.1312 1.2032-14.848 0.8256-23.9488 5.9072-27.3024 15.2512-1.536 4.3328-2.7328 9.4016-3.5648 15.2192l364.3328 0c17.0112 0 30.8096-15.104 30.8096-33.7536l0-37.7088C896 584.9664 882.2016 569.8432 865.1904 569.8432L865.1904 569.8432zM865.1904 790.7648l-365.6384 0.0128c0.096 11.3472 0.2368 22.7904 0.416 34.336 0.2304 14.2272 0.3776 28.2688 0.4672 42.1696 0.0512 8.3712 0.0896 16.6848 0.0896 24.9216l0 3.7952 364.6656 0c17.0112 0 30.8096-15.1104 30.8096-33.76l0-37.696C896 805.8944 882.2016 790.7648 865.1904 790.7648L865.1904 790.7648zM865.1904 128 158.7968 128C141.792 128 128 143.1104 128 161.76l0 37.7024c0 18.6496 13.792 33.76 30.7968 33.76l706.3936 0c17.0112 0 30.8096-15.1168 30.8096-33.76l0-37.7024C896 143.1104 882.2016 128 865.1904 128L865.1904 128zM865.1904 348.928 499.488 348.928l10.9632 16.1152c9.9072 14.5856 19.9616 29.504 30.1696 44.7808l29.856 44.3328 294.7072 0c17.0112 0 30.8096-15.1232 30.8096-33.7664l0-37.7024C896 364.0448 882.2016 348.928 865.1904 348.928L865.1904 348.928zM520.8384 555.6288c2.6944-10.6112-1.8752-23.8784-13.7152-39.808-10.7584-14.7328-22.9952-32.128-36.7104-52.1728-13.7152-20.0512-27.5712-40.5312-41.5552-61.4656-13.9904-20.928-27.5648-40.9792-40.7424-60.1344-13.1776-19.1616-24.8768-35.5264-35.0912-49.0816-10.2208-12.9728-19.776-19.168-28.6464-18.5728-8.8768 0.5888-18.1504 7.6608-27.84 21.2224-10.7648 14.7392-22.9952 32.2752-36.7104 52.6208-13.7152 20.3392-27.8336 41.2672-42.3552 62.7968-14.528 21.5168-28.512 42.2976-41.9584 62.3424-13.4464 20.0448-25.28 37.1456-35.5008 51.3024-9.6832 13.5488-12.5056 24.6144-8.4736 33.1584 4.032 8.5504 13.3184 12.8256 27.84 12.8256 9.1392 0 19.4944 0.3072 31.0656 0.896 11.5648 0.576 21.3824 0.8832 29.4528 0.8832 11.296-0.5888 18.5536 4.2688 21.7856 14.5856 3.2256 10.3168 4.832 24.32 4.832 42.0096l0 41.5616c0 15.3344 0.1408 74.0544 0.4096 89.3888s0.4032 29.7728 0.4032 43.3344l0 34.5024c0 20.0448 3.0912 34.6368 9.28 43.776 6.1888 9.1328 18.1504 13.7088 35.904 13.7088 12.9088 0 24.0704-0.1472 33.4848-0.4416 9.4144-0.3008 19.7696-0.4352 31.0656-0.4352 9.6832 0 17.344-1.7728 22.9952-5.312 5.6448-3.5392 9.952-7.9552 12.9088-13.2672 2.9568-5.2992 4.8384-11.2 5.6448-17.6896 0.8064-6.4832 1.2096-12.672 1.2096-18.56l0-44.2304c0-15.9104-0.1344-32.128-0.4032-48.6336-0.2688-16.512-0.4032-76.128-0.4032-92.0384l0-43.3408c0-11.7888 1.2096-21.0688 3.6224-27.8592 2.4192-6.784 9.0112-10.464 19.7696-11.0528 9.6768 0 21.7792-0.3072 36.3072-0.8832 14.5216-0.5888 26.3552-0.896 35.5008-0.896C509.2736 571.2576 518.1504 566.24 520.8384 555.6288L520.8384 555.6288zM520.8384 555.6288"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-search" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M877.2928 786.7712l-183.7184-183.8016c-2.1504-2.1504-4.512-3.744-6.752-5.5168 31.0144-47.6224 49.152-104.3584 49.152-165.472C735.9744 264.0832 599.904 128 431.9936 128 264.1408 128 128 264.0832 128 431.9808c0 167.936 136.1408 303.968 303.9936 303.968 61.0816 0 117.888-18.144 165.5808-49.2032 1.7344 2.2976 3.3408 4.6016 5.4528 6.7136l183.7632 183.8272c12.5376 12.4992 28.8768 18.72 45.2544 18.72 16.3584 0 32.7232-6.2464 45.248-18.6944C902.24 852.2688 902.24 811.7568 877.2928 786.7712M431.9936 639.9616C317.344 639.9616 224 546.6368 224 431.9488c0-114.6624 93.344-208 207.9936-208 114.6688 0 207.9808 93.3376 207.9808 208C639.9744 546.6368 546.6624 639.9616 431.9936 639.9616"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-sign-out" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M832 500.6208c0 13.056-5.76 24.8768-14.8352 32.9856l-148.0768 132.896c-7.8976 7.0016-18.3488 11.264-29.7472 11.264-24.6016 0-44.5248-19.7888-44.5248-44.2496 0-13.1968 5.76-24.8768 14.8352-32.9792l62.048-55.6544L472.5632 544.8832c-24.5248 0-44.3904-19.7888-44.3904-44.3904 0-24.4608 19.8656-44.2496 44.3904-44.2496l199.136 0-62.048-55.6544c-9.0752-8.1088-14.8352-19.8592-14.8352-32.9792 0-24.4608 19.9232-44.256 44.5248-44.256 11.3984 0 21.8496 4.2624 29.7472 11.4048l148.0768 132.8896C826.24 475.7504 832 487.5712 832 500.6208M406.0096 216.64 280.8384 216.64l0 590.7264 125.1712 0c24.5312 0 44.3904 19.9232 44.3904 44.3904 0 24.6016-19.9296 44.2496-44.3904 44.2496L236.4544 896.0064c-24.5248 0-44.448-19.648-44.448-44.2496L192.0064 172.32C192 147.8592 211.9296 128 236.4544 128l169.5552 0c24.4544 0 44.3904 19.8592 44.3904 44.32C450.4 196.7808 430.5408 216.64 406.0096 216.64"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-movedown" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M158.8096 454.1504l214.0864 0c-12.768-17.9904-18.5664-33.4144-17.4272-46.3104 0.1664-1.8048 0.4608-3.5776 0.8896-5.2736 3.712-14.6304 15.9616-21.5424 36.7616-20.7296 12.6272 0 28.9728-0.4096 49.024-1.2288 20.0512-0.7936 36.7616-1.2032 50.1312-1.2032 14.848-0.8256 23.9488-5.9072 27.3024-15.2512 1.536-4.3328 2.7328-9.4016 3.5648-15.2192L158.8096 348.9344c-17.0112 0-30.8096 15.104-30.8096 33.7536l0 37.7088C128 439.0272 141.7984 454.1504 158.8096 454.1504L158.8096 454.1504zM158.8096 233.2288l365.6384-0.0128c-0.096-11.3472-0.2304-22.7904-0.416-34.336-0.224-14.2272-0.3776-28.2688-0.4672-42.1696-0.0512-8.3712-0.0896-16.6848-0.0896-24.9216L523.4752 128 158.8096 128C141.7984 128 128 143.1104 128 161.76l0 37.696C128 218.0992 141.7984 233.2288 158.8096 233.2288L158.8096 233.2288zM158.8096 895.9936l706.3872 0c17.0048 0 30.8032-15.104 30.8032-33.7536l0-37.7088c0-18.6432-13.792-33.76-30.8032-33.76L158.8096 790.7712c-17.0112 0-30.8096 15.1168-30.8096 33.76l0 37.7088C128 880.8896 141.7984 895.9936 158.8096 895.9936L158.8096 895.9936zM158.8096 675.0656l365.7024 0-10.9632-16.1152c-9.9072-14.5856-19.9616-29.504-30.1696-44.7808l-29.856-44.3328L158.8096 569.8368C141.7984 569.8432 128 584.96 128 603.6096l0 37.7024C128 659.9488 141.7984 675.0656 158.8096 675.0656L158.8096 675.0656zM503.1616 468.3648c-2.6944 10.6112 1.8752 23.8784 13.7152 39.808 10.7584 14.7328 22.9952 32.1344 36.7104 52.1664 13.7152 20.0512 27.5712 40.5376 41.5488 61.4656 13.9904 20.9344 27.5712 40.9792 40.7424 60.1344 13.184 19.1616 24.8832 35.5264 35.0912 49.0816 10.2272 12.9728 19.776 19.168 28.6464 18.5728 8.8832-0.5888 18.1568-7.6608 27.84-21.2224 10.7648-14.7392 22.9952-32.2752 36.7104-52.6272 13.7216-20.3392 27.84-41.2608 42.3552-62.7904 14.5344-21.5232 28.512-42.2976 41.9648-62.3488 13.4464-20.0448 25.2736-37.1456 35.5008-51.3024 9.6832-13.5488 12.5056-24.6144 8.4672-33.1584-4.032-8.5504-13.312-12.8256-27.84-12.8256-9.1392 0-19.4944-0.3072-31.0656-0.896-11.5648-0.576-21.3824-0.8832-29.4528-0.8832-11.296 0.5888-18.5472-4.2688-21.7856-14.5856-3.2256-10.3168-4.832-24.32-4.832-42.0096l0-41.5616c0-15.3344-0.1408-74.0544-0.4096-89.3888-0.2624-15.3344-0.4032-29.7728-0.4032-43.3344L776.6656 186.176c0-20.0448-3.0912-34.6368-9.2736-43.776-6.1952-9.1328-18.1568-13.7088-35.904-13.7088-12.9152 0-24.0704 0.1472-33.4848 0.4416-9.4144 0.3008-19.7696 0.4352-31.0656 0.4352-9.6832 0-17.344 1.7728-22.9952 5.312-5.6448 3.5392-9.9584 7.9552-12.9152 13.2672-2.9568 5.2992-4.8384 11.2-5.6448 17.6896-0.8064 6.4832-1.2032 12.672-1.2032 18.56l0 44.2304c0 15.9104 0.1344 32.128 0.4032 48.6336 0.2688 16.512 0.4032 76.128 0.4032 92.0384l0 43.3408c0 11.7888-1.2096 21.0688-3.6224 27.8592-2.4256 6.784-9.0112 10.464-19.776 11.0528-9.6768 0-21.7728 0.3072-36.3072 0.8832-14.5216 0.5888-26.3552 0.896-35.5008 0.896C514.7264 452.736 505.8496 457.7536 503.1616 468.3648L503.1616 468.3648zM503.1616 468.3648"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-face" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M646.4 473.6c30.72 0 57.6-26.88 57.6-57.6 0-30.7264-26.88-57.6-57.6-57.6-30.7264 0-57.6 26.8736-57.6 57.6C588.8 446.72 615.6736 473.6 646.4 473.6L646.4 473.6 646.4 473.6zM377.6 473.6c30.72 0 57.6-26.88 57.6-57.6 0-30.7264-26.88-57.6-57.6-57.6s-57.6 26.8736-57.6 57.6C320 446.72 346.88 473.6 377.6 473.6L377.6 473.6 377.6 473.6zM512 742.4c99.84 0 184.32-65.28 218.8736-153.6L293.12 588.8C327.68 677.12 412.16 742.4 512 742.4L512 742.4 512 742.4zM512 128c-211.2 0-384 172.8-384 384s172.8 384 384 384 384-172.8 384-384S723.2 128 512 128L512 128 512 128zM512 819.2c-168.96 0-307.2-138.2464-307.2-307.2 0-168.96 138.24-307.2 307.2-307.2 168.9536 0 307.2 138.2336 307.2 307.2C819.2 680.9536 680.9536 819.2 512 819.2L512 819.2 512 819.2zM512 819.2"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-avpic" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M512 128c-212.0768 0-384 171.9232-384 384s171.9232 384 384 384 384-171.9232 384-384S724.0768 128 512 128L512 128zM512 819.1936c-169.6576 0-307.1936-137.536-307.1936-307.1936 0-169.6576 137.536-307.1936 307.1936-307.1936S819.1936 342.3424 819.1936 512C819.1936 681.6576 681.6576 819.1936 512 819.1936L512 819.1936zM512 819.1936M659.9104 487.8528 460.8128 372.896c-18.592-10.7328-41.8368 2.6816-41.8368 24.1536l0 229.9008c0 21.4656 23.2448 34.8864 41.8368 24.1472l199.0976-114.9504C678.5024 525.4208 678.5024 498.5792 659.9104 487.8528L659.9104 487.8528zM659.9104 487.8528"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-up" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M896 680.0128c0 14.3232-5.3568 28.6464-16.0704 39.584-21.4272 21.8688-56.1408 21.8688-77.568 0L512 423.2064l-290.3552 296.3904c-21.4016 21.8688-56.1408 21.8688-77.5744 0-21.4272-21.8688-21.4272-57.2992 0-79.168L473.216 304.4032C483.5008 293.9072 497.4272 288 512 288s28.4992 5.9072 38.784 16.4032l329.1456 336.0256C890.6432 651.36 896 665.6896 896 680.0128L896 680.0128z"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-low" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M896 343.9872c0-14.3232-5.3568-28.6464-16.0704-39.584-21.4272-21.8688-56.1408-21.8688-77.568 0L512 600.7936 221.6448 304.4032c-21.4016-21.8688-56.1408-21.8688-77.5744 0s-21.4272 57.2992 0 79.168l329.1456 336.0256C483.5008 730.0928 497.4272 736 512 736s28.4992-5.9072 38.784-16.4032l329.1456-336.0256C890.6432 372.64 896 358.3104 896 343.9872L896 343.9872z"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-delete" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M191.9808 247.1616c0-21.952 17.9136-39.7952 40.0064-39.7952l200.0384 0 0-39.648c0-21.984 17.8752-39.7184 40.0064-39.7184l80.0128 0c22.0544 0 40.0128 17.8048 40.0128 39.7184l0 39.7888 199.9616 0c22.0544 0 40.0064 17.7728 40.0064 39.7248l0 39.7888L191.9808 287.0208 191.9808 247.1616 191.9808 247.1616zM792.0128 366.2784l0 79.4432 0 410.4896c0 21.9904-17.952 39.7952-40.0064 39.7952L271.9936 896.0064c-22.0928 0-40.0064-17.8048-40.0064-39.7952L231.9872 445.7216 231.9872 366.2784l0-39.648 560.0256 0L792.0128 366.2784 792.0128 366.2784zM392.0128 445.792c0-21.9136-18.0224-39.7888-40.0832-39.7888-21.984 0-39.936 17.8752-39.936 39.7888l0 331.0528c0 21.9136 17.952 39.7184 40.0064 39.7184 22.1312 0 40.0064-17.8048 40.0064-39.7184L392.0128 445.792 392.0128 445.792 392.0128 445.792zM552.0384 445.792c0-21.9136-18.016-39.7888-40.0064-39.7888-22.1312 0-40.0064 17.8752-40.0064 39.7888l0 331.0528c0 21.9136 17.9456 39.7184 40.0064 39.7184 21.9904 0 40.0064-17.8048 40.0064-39.7184L552.0384 445.792 552.0384 445.792zM712 445.792c0-21.9136-17.952-39.7888-40.0128-39.7888-22.1312 0-40.0064 17.8752-40.0064 39.7888l0 331.0528c0 21.9136 17.952 39.7184 40.0064 39.7184 22.0608 0 40.0128-17.8048 40.0128-39.7184L712 445.792 712 445.792z"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-close" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M342.677 595.002M612.287 512l300.867 300.867c18.461 18.461 18.461 48.392 0 66.858l-33.429 33.429c-18.461 18.461-48.397 18.461-66.858 0L512 612.287 211.133 913.154c-18.461 18.461-48.392 18.461-66.853 0l-33.434-33.429c-18.461-18.466-18.461-48.397 0-66.858L411.713 512 110.846 211.133c-18.461-18.457-18.461-48.392 0-66.858l33.434-33.429c18.461-18.461 48.392-18.461 66.853 0L512 411.713l300.867-300.867c18.461-18.461 48.397-18.461 66.858 0l33.429 33.429c18.461 18.466 18.461 48.402 0 66.858L612.287 512z"  ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-arrow-left" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M731.589 954.797c5.976-6.934 5.976-18.192 0-25.126l-406.718-417.68 406.718-417.67c5.976-6.935 5.976-18.183 0-25.119-5.977-6.935-15.657-6.935-21.624 0L292.283 498.544c-3.189 3.691-4.548 8.602-4.332 13.448-0.216 4.847 1.143 9.758 4.332 13.457l417.681 429.348c5.969 6.937 15.648 6.937 21.625 0z" fill="" ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-arrow-right" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M314.035 954.797l417.681-429.348c3.189-3.699 4.548-8.61 4.332-13.457 0.216-4.846-1.143-9.757-4.332-13.448L314.035 69.201c-5.967-6.935-15.647-6.935-21.624 0-5.976 6.936-5.976 18.184 0 25.119l406.718 417.672-406.718 417.68c-5.976 6.933-5.976 18.192 0 25.126 5.977 6.936 15.656 6.936 21.624-0.001z" fill="" ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-fault-repair-b" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M921.1 395.7H693L553.2 255.9c1.5-4.4 2.4-8.9 2.4-13.8 0-24.1-19.5-43.7-43.7-43.7-24.1 0-43.7 19.5-43.7 43.7 0 4.9 1 9.4 2.4 13.8L331 395.7H102.9c-21.4 0-38.9 17.5-38.9 38.9v352c0 21.4 17.5 38.9 38.9 38.9h818.2c21.4 0 38.9-17.5 38.9-38.9v-352c0-21.4-17.5-38.9-38.9-38.9zM477.3 268.4c8 10.5 20.5 17.4 34.7 17.4s26.7-6.9 34.7-17.4L674 395.7H350l127.3-127.3z" fill="#774600" ></path>' +
    '' +
    '</symbol>' +
    '' +
    '<symbol id="icon-hotline-b" viewBox="0 0 1024 1024">' +
    '' +
    '<path d="M778.463 672.434c-12.78-9.003-64.506-13.389-83.89 2.606-19.264 16.111-36.267 39.272-40.966 44.306-4.697 5.093-20.333 23.869-63.56 14.156-43.164-9.89-167.545-138.544-186.334-157.673-18.845-19.074-114.391-122.372-116.295-148.849-2.021-26.416 0.832-40.098 14.387-49.517 13.557-9.593 25.212-23.752 41.559-39.212 16.411-15.46 26.52-48.214 5.293-99.151-21.347-50.941-82.94-104.839-97.034-112.308-14.151-7.577-34.068-31.688-89.063 0-55.119 31.634-73.724 55.445-83.894 83.518-10.165 28.077-27.172 58.048 0 141.091C105.9 434.206 172.427 586.605 301.09 708.92c127 120.715 264.343 208.553 314.882 224.606 50.536 15.994 161.839 50.583 217.489 0 55.293-50.171 54.46-55.914 65.995-67.881 11.533-11.784 26.758-72.439-6.658-112.536-33.415-40.277-101.551-71.669-114.335-80.675zM520.692 64v46.243c217.084 0 393.065 175.981 393.065 393.065H960C960 260.685 763.315 64 520.692 64z" fill="#774600" ></path>' +
    '' +
    '<path d="M751.907 503.308h46.243c0-153.235-124.221-277.458-277.458-277.458v46.243c127.697 0 231.215 103.519 231.215 231.215zM590.056 500.899c0 0.826-0.214 1.59-0.243 2.409h46.243c0.017-0.821 0.243-1.583 0.243-2.409 0-63.848-51.759-115.607-115.607-115.607v46.243c38.309-0.001 69.364 31.056 69.364 69.364z" fill="#774600" ></path>' +
    '' +
    '</symbol>' +
    '' +
    '</svg>'
  var script = function() {
    var scripts = document.getElementsByTagName('script')
    return scripts[scripts.length - 1]
  }()
  var shouldInjectCss = script.getAttribute("data-injectcss")

  /**
   * document ready
   */
  var ready = function(fn) {
    if (document.addEventListener) {
      if (~["complete", "loaded", "interactive"].indexOf(document.readyState)) {
        setTimeout(fn, 0)
      } else {
        var loadFn = function() {
          document.removeEventListener("DOMContentLoaded", loadFn, false)
          fn()
        }
        document.addEventListener("DOMContentLoaded", loadFn, false)
      }
    } else if (document.attachEvent) {
      IEContentLoaded(window, fn)
    }

    function IEContentLoaded(w, fn) {
      var d = w.document,
        done = false,
        // only fire once
        init = function() {
          if (!done) {
            done = true
            fn()
          }
        }
        // polling for no errors
      var polling = function() {
        try {
          // throws errors until after ondocumentready
          d.documentElement.doScroll('left')
        } catch (e) {
          setTimeout(polling, 50)
          return
        }
        // no errors, fire

        init()
      };

      polling()
        // trying to always fire before onload
      d.onreadystatechange = function() {
        if (d.readyState == 'complete') {
          d.onreadystatechange = null
          init()
        }
      }
    }
  }

  /**
   * Insert el before target
   *
   * @param {Element} el
   * @param {Element} target
   */

  var before = function(el, target) {
    target.parentNode.insertBefore(el, target)
  }

  /**
   * Prepend el to target
   *
   * @param {Element} el
   * @param {Element} target
   */

  var prepend = function(el, target) {
    if (target.firstChild) {
      before(el, target.firstChild)
    } else {
      target.appendChild(el)
    }
  }

  function appendSvg() {
    var div, svg

    div = document.createElement('div')
    div.innerHTML = svgSprite
    svgSprite = null
    svg = div.getElementsByTagName('svg')[0]
    if (svg) {
      svg.setAttribute('aria-hidden', 'true')
      svg.style.position = 'absolute'
      svg.style.width = 0
      svg.style.height = 0
      svg.style.overflow = 'hidden'
      prepend(svg, document.body)
    }
  }

  if (shouldInjectCss && !window.__iconfont__svg__cssinject__) {
    window.__iconfont__svg__cssinject__ = true
    try {
      document.write("<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>");
    } catch (e) {
      console && console.log(e)
    }
  }

  ready(appendSvg)


})(window)