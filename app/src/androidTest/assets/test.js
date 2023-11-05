



const gsm=require("gsmarena-api")

async function getPhone(){
    const brands = (await gsmarena.catalog.getDevice("apple_iphone_15_plus-12558"));
    return brands;
}